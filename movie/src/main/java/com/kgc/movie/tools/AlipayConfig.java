package com.kgc.movie.tools;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102800774695";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBbVqQbRcqwS1bb5eylggQbwQunNkyN+A/s2s4/+HQnvluuY2rhVMEUxKmKdTG7J6bAH/++gX7RhuFMS0/qcP+/d+ghe6RdIvRQy9p0SxxBmS+LB4exWyfXTnfrn3TRliHN04g3HFUtt1glbmkvs1NVNR0WdvkL/YyrYGNY0J9Uw2VzS0ibk/1nRFeqN0hyDlfsZDua/gx7pQ01Axgz/eXP0e0vLSbg2CZWcQjCvRk996g4TTSYiUJdWwZiJCx1+Gd6Ndtp/+q2TPbNpXwUZiXG70o9HKJ0/sfT5Kct1OdRTDx92XH9Pb8c+6V6yngZXtQTpguMBHjnc4P0w4JnUwZAgMBAAECggEACFsN+LsCPuFf00JeEcp71MvGAlhf8U0ILjSgHHrwki5hPhO+oK8nz+SpFI8ozHrkNm+O0+BCWJmLF0s4d563J5QuRse+wic7C5SB0BwP+XAHOvvQKf5m59b18InsV6J3/qrEYXy52FVB74VbCdbDnFV4rdZLSu0JwPXQolchKMQGB5gWLj/X13Da13wS1VeoQTG55qcRk+BB8R9bPNtVVu1H8TrmMXy2fEu5UzT+6M6KHBwlYCzZ6PMbvNH6p36+IsaYL9W3b7d28a1gs+aPOYYvLej4rtevvW31V1YG0wMR+lb/kQ0KvRMW7/KmUInz8L03orMQYrigeXJ1szYQbQKBgQD+/sEL7d9ekW5U9QJuBJUWy6C/3fJuqcmJOl3WgZSiB0f0DUqsyNM7tFQjxjqFGUIJJudMrGiCADGUZrN++23tVHs6O6ZxGkPCFvp899LFesC/Qf+/B5C2g/EpUrYRrImdSiivClHEeiiTSpKKCjvcqVF3bpt5uyuclEPTr//NnwKBgQCB7+xgt09YiVn7BAFqXpOqizumJJCD9/gommvIGgJD8H7tnELucpxMxHUKX3UA4narv6nUCn3lucJhDRBGkOBTblpgHnfzR9yepzumqI0oLUW2MnU9eSofcweZbxKc8FDI4DNHtaymIOPzlcsV3zjmEVkx7+Ha6KwV4zW7IFSbRwKBgGBDglNjkLDdzD4sZKdt+W6qntvwCQa3+EpjC2vgbWEhyIscvXUvN3dRo3YB7rOyjlhwJF+wsp9pPU5d2yNz/dLb0s1wGWyXUr8h95xX3m0I410QqGDQlVQhyVglTnCrpyQHDAbQqX+38jtwqpOMO38ZOJUS34T8IQGyg0yWI8bXAoGAU4PtL2DC/AoULpWtfzvYt5YUOb5osJnSA+709cFZ0Wcjff+guXgq4+ClxYwDPRVR5yQiuOohb2VM/WoTGvgFZzqXlg4fVNvMfqDIY18Uk0098FRQLLnTDDG4IbNViE+h7OrFqwKnPIQJX8fYp285OA7QgJtJVJWV/d9y6ppmJwMCgYEAn43/KbW5Em1dwI+ZECo/K0QAjdnDn1rwAAeQm8P72wFBC6XSQSfwDBWn++ydxLEaOgIgix47ayjEyGq823ob+xjA/3gPexJ63xZldlA9oe8Mi1VsFRPVqeecrjWwZBOFRssUabX6eW4sQhyoTTUEqcRxxqKBuv9vp9tGOl3X5ns=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsONJ5gZRFdxsdQgIQMa+fVSkHnw0OY1V6UUSv/LZgbRi0nZucDykUfTvo1igc3K54BEX0Ivb0JRtqX6VJrID6jw+mALk7HYJ7tvFWyv2/dlHRbrTfAxhVI65T3vY40kYJBGsFGCkQox7OoAOnlyHE9J1TQDgYyvKn/XhgPhGSJR7BzueJLwLELBQHEhm3tOLlxrC6yu6Bzgcdx2NTW5FQAG+SO6Osh8QkQRBBELPNQBUhgtveqqlo0TYvAbKQE/BnxqcOWIZU7CjRRg8oUNg48YSrtFjtTil4Y0o6fv/Ga5hMM/uvrEJO2xIICtoMYvLOYm3mZaivkwXM/FlrbTxKQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/static/jsp/zf-success.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

