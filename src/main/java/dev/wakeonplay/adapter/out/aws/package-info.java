/**
 * Cloud outbound adapter: implements the {@code CloudProvider} port on AWS.
 * Each customer server is a CloudFormation stack (ADR 017); EC2 and Route 53
 * handle starting, stopping and the address.
 *
 * <p>Rule: this is the only package allowed to import the CloudFormation SDK. The domain
 * receives only an opaque {@code ProviderRef}.
 */
package dev.wakeonplay.adapter.out.aws;
