/**
 * Outbound ports: what the domain needs from the outside world, in the domain's language.
 * For example {@code CloudProvider}, {@code GameAdapter} and the repositories.
 *
 * <p>Rule: depends only on {@code domain}. No concept specific to a cloud, database or game
 * appears here (for example, no stack, ARN or table).
 */
package dev.wakeonplay.application.port.out;
