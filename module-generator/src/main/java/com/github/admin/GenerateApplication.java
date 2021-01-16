package com.github.admin;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenerateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateApplication.class, args);
        generateDocs();
    }

    private static void generateDocs() {
        DocsConfig config = new DocsConfig();
        config.setProjectPath("e://admin-structure//module-generator");
        config.setProjectName("test");
        config.setApiVersion("V1.0");
        config.setDocsPath("D://test-api");
        config.setAutoGenerate(Boolean.TRUE);

        Docs.buildHtmlDocs(config);
    }
}
