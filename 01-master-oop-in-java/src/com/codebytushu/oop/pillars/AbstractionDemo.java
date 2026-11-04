package com.codebytushu.oop.pillars;

/**
 * Demonstrates Abstraction in Java using Abstract Classes and Interfaces.
 * Hides complex implementation details and exposes only essential operations.
 * 
 * @author CodeByTushu
 */
public class AbstractionDemo {

    public static abstract class CloudStorageProvider {
        protected String bucketName;

        public CloudStorageProvider(String bucketName) {
            this.bucketName = bucketName;
        }

        // Concrete method (shared behavior)
        public void connect() {
            System.out.println("🔗 Established secure TLS connection to bucket: " + bucketName);
        }

        // Abstract methods (enforced contracts)
        public abstract void uploadFile(String fileName, byte[] data);
        public abstract byte[] downloadFile(String fileName);
    }

    public static class AWS_S3_Storage extends CloudStorageProvider {
        public AWS_S3_Storage(String bucketName) {
            super(bucketName);
        }

        @Override
        public void uploadFile(String fileName, byte[] data) {
            System.out.println("☁️ [AWS S3] Uploaded " + fileName + " (" + data.length + " bytes) to Amazon S3 Standard Storage");
        }

        @Override
        public byte[] downloadFile(String fileName) {
            System.out.println("☁️ [AWS S3] Downloaded " + fileName + " from Amazon S3");
            return new byte[100];
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Abstraction Demo ===");
        CloudStorageProvider storage = new AWS_S3_Storage("codebytushu-study-notes");
        storage.connect();
        storage.uploadFile("Java_OOP_Guide.pdf", new byte[1024]);
    }
}
