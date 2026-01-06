package com.example.dailyquotes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    private TextView quoteTextView;
    private TextView counterTextView;
    private Button getQuoteButton;
    private int quoteCount = 0;
    
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
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 初始化视图
        quoteTextView = findViewById(R.id.quoteTextView);
        counterTextView = findViewById(R.id.counterTextView);
        getQuoteButton = findViewById(R.id.getQuoteButton);
        
        // 设置按钮点击监听器
        getQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取随机名言
                int index = (int)(Math.random() * quotes.length);
                String newQuote = quotes[index];
                quoteTextView.setText(newQuote);
                
                // 更新计数器
                quoteCount++;
                updateCounter();
                
                // 更新按钮文本
                getQuoteButton.setText("再换一句 (" + quoteCount + ")");
            }
        });
        
        // 长按按钮重置
        getQuoteButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                quoteCount = 0;
                updateCounter();
                getQuoteButton.setText("获取新名言");
                quoteTextView.setText("点击下方按钮获取名言");
                Toast.makeText(MainActivity.this, "计数器已重置", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    
    private void updateCounter() {
        String counterText = "已生成名言：" + quoteCount + " 条";
        counterTextView.setText(counterText);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentQuote", quoteTextView.getText().toString());
        outState.putInt("quoteCount", quoteCount);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String savedQuote = savedInstanceState.getString("currentQuote");
            quoteCount = savedInstanceState.getInt("quoteCount", 0);
            
            quoteTextView.setText(savedQuote);
            updateCounter();
            
            if (quoteCount > 0) {
                getQuoteButton.setText("再换一句 (" + quoteCount + ")");
            }
        }
    }
}
