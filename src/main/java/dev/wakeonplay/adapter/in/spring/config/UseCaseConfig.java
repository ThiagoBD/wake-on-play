package dev.wakeonplay.adapter.in.spring.config;

import org.springframework.context.annotation.Configuration;

/**
 * MVP wiring: here the use cases from {@code application.service} receive the
 * outbound adapters and become Spring beans. It is the only MVP class that instantiates
 * outbound adapters (ArchUnit rule). The Lambda equivalent is {@code Wiring}.
 *
 * <p>Example, once the first use case exists:
 * <pre>{@code
 * @Bean
 * ReceiveHeartbeatUseCase receiveHeartbeat(GameServerRepository servers, Clock clock) {
 *     return new ReceiveHeartbeatService(servers, clock);
 * }
 * }</pre>
 */
@Configuration
class UseCaseConfig {
}
