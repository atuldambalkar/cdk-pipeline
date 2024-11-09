# CDK Pipeline App
CDK Pipeline Project

## Steps
### Option I - AWS Code Pipelone
- Create AWS CodePipeline GitHub Connection from Settings menu on AWS Console.
- ARN for this Connection will be used the in CDK Code during deployment.
 
### Option II - GitHub Personal Access Token
- Create The GitHub Personal Access Token (classic) for OAuth with necessary Permissions for Repo and Webhook
- Add this token to AWS SecretsManager as name "github-token"

# References
- https://docs.aws.amazon.com/cdk/v2/guide/cdk_pipeline.html
- https://docs.aws.amazon.com/cdk/v2/guide/serverless_example.html
- https://docs.aws.amazon.com/cdk/api/v2/java/software/amazon/awscdk/pipelines/package-summary.html
