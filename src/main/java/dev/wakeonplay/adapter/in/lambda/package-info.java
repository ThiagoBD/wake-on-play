/**
 * v2 inbound adapters: AWS Lambda handlers (public API, agent API and reconciler)
 * and the {@code Wiring} class, which wires dependencies by hand, without Spring.
 *
 * <p>Compiled only in the {@code lambda} profile. Rule: calls only use cases from
 * {@code application.port.in}; no business rules live here.
 */
package dev.wakeonplay.adapter.in.lambda;
