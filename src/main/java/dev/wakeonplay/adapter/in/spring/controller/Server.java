package dev.wakeonplay.adapter.in.spring.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Server {


    @PostMapping("/create")
    public String createServer(){


        return "created server";
    }

    @PostMapping("/Stop")
    public String stopServer(){


        return "stop server";
    }

    @PostMapping("/Start")
    public String startServer(){


        return "start server";
    }

    @PostMapping("/destroy")
    public String destroyServer(){


        return "destroy server";
    }
}
