package com.example.thuoctay.goi_chuc_nang_thong_minh;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/runapp")
@CrossOrigin
public class AppRunnerController {

    private Process runningProcess;
    private int status = 0;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private String trangThai = "";
    private String currentDirectory = System.getProperty("user.dir");

    @GetMapping
    public ResponseEntity<?> runOrCheckExternalApp() {
        System.out.println("\nStatus: " + status);
        System.out.println("\n\nDIR: "+ currentDirectory);
        if (status == 1) {
            return ResponseEntity.ok().body("Ứng dụng đang chạy.");
        }
        try {
                status = 1;
                executor.execute(() -> {
                    try {
                        trangThai = "Chương trình đang chạy!";
                        String pythonCommand = "py";
                        String pythonScript = currentDirectory + "/model/main.py";

                        // Tạo một ProcessBuilder với lệnh Python và tên tệp Python
                        ProcessBuilder processBuilder = new ProcessBuilder(pythonCommand, pythonScript);

                        // Đặt thư mục làm việc (nếu cần)
                        // processBuilder.directory(new File("đường_dẫn_đến_thư_mục"));

                        // Bắt đầu thực thi lệnh
                        Process process = processBuilder.start();

                        // Đọc đầu ra của lệnh
                        InputStream inputStream = process.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }

                        // Chờ tiến trình hoàn thành
                        int exitCode = process.waitFor();
                        System.out.println("Lệnh đã hoàn thành với mã thoát: " + exitCode);
                    if (exitCode == 0) {
                            trangThai = "Đã chạy thành công!";
                            System.out.println("Command executed successfully.");
                        } else {
                            trangThai = "Chạy thất bại!";
                            System.out.println("Command execution failed.");
                        }
                        
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                        trangThai = "Chạy lỗi";
                    }

                    status = 0;
                });
                return ResponseEntity.ok().body("Chạy thành công");
            } catch (Exception e) {
                status = 0;
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }

    @GetMapping("/check")
    public ResponseEntity<?> check() {
        return ResponseEntity.ok().body("{\"status\":\"" + status + "\", \"message\": \"" + trangThai + "\"}");
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Đường dẫn hiện tại của project: " + currentDirectory);
        return ResponseEntity.ok().body(currentDirectory);
    }
}
