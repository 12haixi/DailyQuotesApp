package com.example.dailyquotes;

import java.util.Random;

public class QuoteGenerator {
    private final String[] quotes = {
        "千里之行，始于足下。",
        "Stay hungry, stay foolish.",
        "代码改变世界。",
        "简单就是美。",
        "今天的努力，明天的收获。",
        "学而不思则罔，思而不学则殆。",
        "实践是检验真理的唯一标准。",
        "生活就像一盒巧克力，你永远不知道下一颗是什么味道。",
        "成功不是将来才有的，而是从决定去做的那一刻起，持续累积而成。",
        "不积跬步，无以至千里；不积小流，无以成江海。"
    };
    
    private final Random random = new Random();
    
    public String getRandomQuote() {
        int index = random.nextInt(quotes.length);
        return quotes[index];
    }
    
    public int getQuoteCount() {
        return quotes.length;
    }
}
