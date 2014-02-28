package pl.otros.logview.exceptionshandler.errrorreport;

import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 */
public class ErrorReportSenderTest {

    @Test
    public void addHttpPostParams() {

        //given
        ErrorReportSender sender = new ErrorReportSender();
        Map<String, String> values = new HashMap<String, String>();
        values.put("key1", "value1");
        values.put("key2", "value2");

        PostMethod method = new PostMethod();

        //when
        sender.addHttpPostParams(values, method);

        //then
        assertEquals("value1", method.getParameter("key1").getValue());
        assertEquals("value2", method.getParameter("key2").getValue());
    }

    @Test
    public void addHttpPostParamsIsNullSafe() {
        //given
        ErrorReportSender sender = new ErrorReportSender();
        Map<String, String> values = new HashMap<String, String>();
        values.put("key2", null);

        PostMethod method = new PostMethod();

        //when
        sender.addHttpPostParams(values, method);

        //then
        assertEquals("null", method.getParameter("key2").getValue());
    }
}