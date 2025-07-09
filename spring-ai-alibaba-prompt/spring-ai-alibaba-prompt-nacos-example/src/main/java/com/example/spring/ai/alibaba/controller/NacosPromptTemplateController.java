package com.example.spring.ai.alibaba.controller;

import com.alibaba.cloud.ai.prompt.ConfigurablePromptTemplate;
import com.alibaba.cloud.ai.prompt.ConfigurablePromptTemplateFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/prompt/nacos/template/factory")
public class NacosPromptTemplateController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NacosPromptTemplateController.class);

    private final ChatClient dashScopeChatClient;
    private final ConfigurablePromptTemplateFactory promptTemplateFactory;

    @Autowired
    public NacosPromptTemplateController(ChatClient dashScopeChatClient, ConfigurablePromptTemplateFactory configurablePromptTemplateFactory) {
        this.dashScopeChatClient = dashScopeChatClient;
        this.promptTemplateFactory = configurablePromptTemplateFactory;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("author") String author) {
        // 程序启动时，会回调com.alibaba.cloud.ai.prompt.ConfigurablePromptTemplateFactory.onConfigChange方法，覆盖掉默认的提示词模板
        ConfigurablePromptTemplate promptTemplate = promptTemplateFactory.create("prompt-template-article",
                "please list the three most famous books by this {author}.");

        // 填充提示词模板参数
        Prompt prompt = promptTemplate.create(Map.of("author", author));
        log.info("prompt: {}", prompt.getContents());

        return dashScopeChatClient.prompt(prompt)
                .call()
                .content();
    }

}

