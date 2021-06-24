import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreadDemo02 extends Thread {
    private String url;
    private String name;

    // 构造函数
    public ThreadDemo02(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        // 进程主要运行 webDownloader.download
        WebDownloader webDownloader = new WebDownloader();
        try {
            webDownloader.download(url, name);
            System.out.println("图片下载进程。。。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载图片错误。。。");
        }

    }

    public static void main(String[] args) {
        ThreadDemo02 t1 = new ThreadDemo02("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=1561546013,1259770086&fm=85&s=1A21EC02EE337FAF0854119903001062","1.jpg");
        ThreadDemo02 t2 = new ThreadDemo02("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=3506652242,2368086075&fm=85&s=8C9F875066675AAE078DE4D6030050F1","2.jpg");
        ThreadDemo02 t3 = new ThreadDemo02("https://dss0.baidu.com/73t1bjeh1BF3odCf/it/u=2623032014,2137091052&fm=85&s=F4C2BE56F74162EE0E5EEC7C03004071","3.jpg");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("main进程。。。");
    }
}

// 下载器, FileUtils.copyURLToFile 把网络图片地址，下载到本地
class WebDownloader {
    public void download(String url, String name) throws IOException {
        FileUtils.copyURLToFile(new URL(url), new File(name));
    }
}
