package com.codebytushu.oop.patterns;

/**
 * Demonstrates Gang of Four (GoF) Creational Design Patterns in Java.
 * - Singleton (Double-Checked Locking, Thread-Safe)
 * - Factory Pattern
 * - Builder Pattern
 * 
 * @author CodeByTushu
 */
public class DesignPatternsDemo {

    // 1. Thread-safe Singleton Pattern
    public static class DatabasePool {
        private static volatile DatabasePool instance;
        private final String connectionString;

        private DatabasePool() {
            this.connectionString = "jdbc:postgresql://db.codebytushu.com:5432/main_db";
            System.out.println("🔧 Initializing Database Pool connection...");
        }

        public static DatabasePool getInstance() {
            if (instance == null) {
                synchronized (DatabasePool.class) {
                    if (instance == null) {
                        instance = new DatabasePool();
                    }
                }
            }
            return instance;
        }

        public void executeQuery(String sql) {
            System.out.println("⚡ [" + connectionString + "] Executing: " + sql);
        }
    }

    // 2. Factory Pattern
    public interface Logger {
        void log(String message);
    }

    public static class ConsoleLogger implements Logger {
        @Override public void log(String msg) { System.out.println("[CONSOLE] " + msg); }
    }

    public static class FileLogger implements Logger {
        @Override public void log(String msg) { System.out.println("[FILE-LOG] " + msg); }
    }

    public static class LoggerFactory {
        public static Logger getLogger(String type) {
            if ("FILE".equalsIgnoreCase(type)) return new FileLogger();
            return new ConsoleLogger();
        }
    }

    // 3. Builder Pattern
    public static class ServerConfig {
        private final String host;
        private final int port;
        private final boolean sslEnabled;
        private final int timeoutMs;

        private ServerConfig(Builder builder) {
            this.host = builder.host;
            this.port = builder.port;
            this.sslEnabled = builder.sslEnabled;
            this.timeoutMs = builder.timeoutMs;
        }

        public static class Builder {
            private String host = "localhost";
            private int port = 8080;
            private boolean sslEnabled = false;
            private int timeoutMs = 5000;

            public Builder setHost(String host) { this.host = host; return this; }
            public Builder setPort(int port) { this.port = port; return this; }
            public Builder setSslEnabled(boolean sslEnabled) { this.sslEnabled = sslEnabled; return this; }
            public Builder setTimeoutMs(int timeoutMs) { this.timeoutMs = timeoutMs; return this; }

            public ServerConfig build() {
                return new ServerConfig(this);
            }
        }

        @Override
        public String toString() {
            return "ServerConfig {host='" + host + "', port=" + port + ", ssl=" + sslEnabled + ", timeout=" + timeoutMs + "ms}";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Design Patterns Demo ===");
        
        // Singleton
        DatabasePool pool1 = DatabasePool.getInstance();
        DatabasePool pool2 = DatabasePool.getInstance();
        System.out.println("Singletons identical? " + (pool1 == pool2));
        pool1.executeQuery("SELECT * FROM users LIMIT 10;");

        // Factory
        Logger logger = LoggerFactory.getLogger("FILE");
        logger.log("Application started successfully.");

        // Builder
        ServerConfig config = new ServerConfig.Builder()
                .setHost("api.codebytushu.com")
                .setPort(443)
                .setSslEnabled(true)
                .setTimeoutMs(3000)
                .build();
        System.out.println("Configured Server: " + config);
    }
}
