package com.nix.devops.deployment.pipeline.stage;

import com.nix.devops.deployment.application.ApplicationStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.Stage;
import software.amazon.awscdk.StageProps;
import software.constructs.Construct;

public class ApplicationStage extends Stage {

    public ApplicationStage(@NotNull Construct scope, @NotNull String id) {
        super(scope, id);
    }

    public ApplicationStage(@NotNull Construct scope, @NotNull String id, @Nullable StageProps props) {
        super(scope, id, props);

        Stack applicationStack = new ApplicationStack(this, "ApplicationStack");
    }


}
