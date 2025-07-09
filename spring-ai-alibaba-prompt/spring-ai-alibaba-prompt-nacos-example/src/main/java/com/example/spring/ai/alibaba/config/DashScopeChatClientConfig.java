package com.example.spring.ai.alibaba.config;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DashScopeChatClientConfig {

    @Bean
    public ChatClient dashScopeChatClient(ChatModel chatModel) {
        return ChatClient.builder(chatModel)
                .defaultAdvisors(
                        // 实现 Logger 的 Advisor
                        new SimpleLoggerAdvisor()
                )
                .defaultOptions(
                        // 设置 ChatClient 中 ChatModel 的 Options 参数
                        DashScopeChatOptions.builder()
                                .withTopP(0.7)
                                .build()
                ).build();
    }

}


