/**
 * Game outbound adapter: implements the {@code GameAdapter} port by leaving orders
 * in a command queue, delivered to the agent in the response to its next heartbeat (ADR 005).
 * The backend never talks to the game directly.
 *
 * <p>Rule: does not depend on other adapters.
 */
package dev.wakeonplay.adapter.out.agent;
