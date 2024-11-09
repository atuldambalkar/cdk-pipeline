package com.nix.devops.deployment.pipeline;

import com.nix.devops.deployment.pipeline.stage.ApplicationStage;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StageProps;
import software.amazon.awscdk.pipelines.*;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

/**
 * arn:aws:codeconnections:us-east-1:777403676412:connection/05f36240-0142-4f17-bf72-183eb3d41d83
 */
public class CdkPipelineStack extends Stack {
    public CdkPipelineStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CdkPipelineStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here

        CodePipelineSource source = CodePipelineSource
                .connection("atuldambalkar/cdk-pipeline", "main",
                        ConnectionSourceOptions.builder()
                .connectionArn("arn:aws:codeconnections:us-east-1:777403676412:connection/05f36240-0142-4f17-bf72-183eb3d41d83")
                .build());

        CodePipeline pipeline = CodePipeline.Builder.create(this, "pipeline")
                .pipelineName("CdkPipeline")
                .synth(ShellStep.Builder.create("Synth")
                        .input(source)
                        .commands(Arrays.asList("npm install -g aws-cdk", "npx cdk synth"))
                        .primaryOutputDirectory("cdk.out")
                        .build())
                .build();

        StageDeployment testingStage =
                pipeline.addStage(new ApplicationStage(this, "test", StageProps.builder()
                        .env(Environment.builder()
                                .account("777403676412")
                                .region("us-east-1")
                                .build())
                        .build()));

//        testingStage.addPost(new ManualApprovalStep("approval"));

    }
}
