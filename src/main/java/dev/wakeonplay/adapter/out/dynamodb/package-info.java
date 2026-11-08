/**
 * Persistence outbound adapter: implements the repositories from
 * {@code application.port.out} on DynamoDB (DynamoDB Local in the MVP). State
 * transitions use conditional writes on state and version (ADRs 002 and 003).
 *
 * <p>Rule: does not depend on other adapters.
 */
package dev.wakeonplay.adapter.out.dynamodb;
