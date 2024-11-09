package com.nix.devops.deployment.pipeline;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

public class CdkPipelineApp {

    public static void main(final String[] args) {

        App app = new App();

        // For more information, see https://docs.aws.amazon.com/cdk/latest/guide/environments.html
        new CdkPipelineStack(app, "CdkPipelineStack", StackProps.builder()
               .env(Environment.builder()
//                        .account(System.getenv("CDK_PIPELINE_ACCOUNT"))
//                        .region(System.getenv("AWS_REGION"))
                       .account("777403676412")
                       .region("us-east-1")
                        .build())
                .build());

        app.synth();
    }
}

