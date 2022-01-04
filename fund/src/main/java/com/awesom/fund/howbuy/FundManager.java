package com.awesom.fund.howbuy;

import com.awesom.fund.util.StringUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author yangdejun
 * @date 2020/09/21
 **/
@RestController
public class FundManager {
    private static final String URL = "https://www.howbuy.com/fund/company/80041198/managerlist";
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .build();
        String html;
        try (Response response = client.newCall(request).execute()) {
            html = response.body().string();
        }

        Document document = Jsoup.parseBodyFragment(html);
        Elements table = document.getElementsByClass("manager_list_con");
        Element tabel1 = table.get(0);
        Elements tr = tabel1.getElementsByTag("tr");

        for (int i = 1; i < 2; i++) {
            // 第 i 行数据
            Element element = tr.get(i);
            // 序号
            System.out.println(element.getElementsByClass("tdc").get(0).text());
            // 基金经理编号
            System.out.println(StringUtil.extractNums(element.getElementsByClass("tdl").select("a").attr("href")));
            // 基金经理名称
            System.out.println(element.getElementsByClass("tdl").text());
            // 任公司经理起始日
            System.out.println(element.getElementsByClass("tdr").get(0).text());
            // 本公司任职天数
            System.out.println(formatDay(StringUtil.extractSplitNums(element.getElementsByClass("tdr").get(1).text())));
            // 从业天数
            System.out.println(formatDay(StringUtil.extractSplitNums(element.getElementsByClass("tdr").get(1).text())));
            // 旗下基金数量
            System.out.println(element.getElementsByClass("tdr").get(3).text());
        }

    }

    private static String formatDay(List<String> var) {
        String response;
        int yearParseDays = 0;
        if (var.size() == 1) {
            return var.get(0);
        }
        if (var.size() == 2) {
            return String.valueOf(Integer.valueOf(var.get(0)) * 365 + Integer.valueOf(var.get(1)));
        }
        return null;
    }
}
