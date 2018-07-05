package com.udian;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ImageUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void captchaTest01()
    {
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(300, 100);
        circleCaptcha.write("d:\\image.jpg");
        System.out.println(circleCaptcha.getCode());
    }

    @Test
    public void captchaTest02()
    {
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(300, 100);
        ImageUtil.write(circleCaptcha.createImage("12345"), FileUtil.touch("d:\\image.jpg"));
    }

    @Test
    public void qrCodeTest01() {
//        ("http://www.baidu.com", 300, 300);
        String content = "https://www.baidu.com/s?wd=abc&rsv_spt=1&rsv_iqid=0xd0c32e2a00033705&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=1&rsv_sug1=1&rsv_sug7=001";
        QrCodeUtil.generate(content, 300, 300, FileUtil.touch("d:\\qr.png"));
    }

    @Test
    public void poiTest01(){
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\Administrator\\Desktop\\toB腾讯云服务器部署详情.xlsx"), 0);
        List<List<Object>> read = reader.read();
        List<Map<String, Object>> maps = reader.readAll();

    }

    @Test
    public void pathTest(){
        URL resource = getClass().getClassLoader().getResource("shiro.ini");
        System.out.println(resource.getPath());
    }

    @Test
    public void freemarkerTest() throws Exception {
        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(FileUtil.file("classpath:templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
        Map root = new HashMap();
        root.put("user", "Big Joe");
        Map latest = new HashMap();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("test.ftl");

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
    }
}
