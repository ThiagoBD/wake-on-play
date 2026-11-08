# Platform Terraform

Infrastructure for the **control plane**: API Gateway, Lambdas, DynamoDB, EventBridge, platform IAM roles, alarms and the shared base (VPC, subnets, launch template, AMI and saves bucket).

Rule: no resource that exists because of a game server goes here. Those resources are created at runtime by the `CloudProvider`, with one CloudFormation stack per server (ADR 017).

Arrives in v2.
