/**
 * Wake on Play domain: the {@code GameServer} aggregate, the state machine,
 * the entities ({@code GameTemplate}, {@code Session}, {@code Backup}, {@code Member},
 * {@code LifecycleEvent}) and the business rules, such as the idle rule.
 *
 * <p>Rule: plain Java only. No Spring, AWS, Palworld or any other framework.
 * Checked by {@code ArchitectureTest}.
 */
package dev.wakeonplay.domain;
