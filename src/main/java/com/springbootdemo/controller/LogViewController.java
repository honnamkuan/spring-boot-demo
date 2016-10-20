package com.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("logs")
public class LogViewController
{
    @Value("${log.view.directory}")
    private String directory;

    @GetMapping(value = "{file:.+}", produces = MediaType.TEXT_PLAIN_VALUE)
    public FileSystemResource getFile(@PathVariable("file") String pFileName)
    {
        Path filePath = Paths.get(directory, pFileName);
        return new FileSystemResource(filePath.toFile());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<URI> listDirectory() throws IOException
    {
        Path filePath = Paths.get(directory);

        Function<Path, URI> filePathToHttpURI = path -> {
            String fileName = path.getFileName().toString();
            return ControllerLinkBuilder.linkTo(LogViewController.class).slash(fileName).toUri();
        };

        return Files.list(filePath).map(filePathToHttpURI).collect(Collectors.toCollection(TreeSet::new));


    }

}
