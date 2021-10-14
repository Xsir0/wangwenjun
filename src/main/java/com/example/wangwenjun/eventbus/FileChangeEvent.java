package com.example.wangwenjun.eventbus;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * @ClassName FileChangeEvent
 * @Description
 * @Author xsir
 * @Date 2021/10/13 上午6:58
 * @Version V1.0
 */
public class FileChangeEvent {

    private final Path path;

    private final WatchEvent.Kind<?> kind;

    public FileChangeEvent(Path path,WatchEvent.Kind<?> kind){
        this.path = path;
        this.kind = kind;
    }

    public Path getPath(){
        return path;
    }
    public WatchEvent.Kind<?> getKind(){
        return kind;
    }
}
