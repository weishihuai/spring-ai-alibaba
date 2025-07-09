# 使用 Nacos 的动态配置管理功能

1. 启动 Nacos 服务；
2. 写入配置，dataId 为：spring.ai.alibaba.configurable.prompt
3. 在配置中写入内容，注意格式必须如下。参考com.alibaba.cloud.ai.prompt.ConfigurablePromptTemplateFactory.ConfigurablePromptTemplateModel类的定义
    ```json
    [
      {
        "name": "prompt-template-article",
        "template": "列出 {author} 有名的著作",
        "model": {
          "author": "余华"
        }
      }
    ]
    ```
4. 请求接口： http://localhost:1008/prompt/nacos/template/factory/chat?author=鲁迅
5. 修改nacos配置内容
6. 无需重启项目，再次请求：http://localhost:1008/prompt/nacos/template/factory/chat?author=鲁迅 将会看到，动态prompt的效果。
   