package dev.wakeonplay.application.port.in;

public interface IServerService {

    void createServer();

    void stopServer();

    void startServer();

    void destroyServer();

}
