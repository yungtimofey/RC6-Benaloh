package com.company.crypto.aesImpl.mode.impl;

import com.company.crypto.aesImpl.CypherInformant;
import com.company.crypto.aesImpl.SymmetricBlockCypher;
import com.company.crypto.aesImpl.algorithm.impl.RC6Bits32;
import com.company.crypto.aesImpl.mode.SymmetricalBlockMode;
import com.company.crypto.aesImpl.round.impl.RoundKeysGeneratorImpl;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

class CTRCypherTest {
    @Test
    void checkText() {
        RC6Bits32 rc6 = RC6Bits32.getInstance(
                new RoundKeysGeneratorImpl(32, 20, RC6Bits32.CipherKeyLength.BIT_128)
        );

        int keyLength = RC6Bits32.CipherKeyLength.BIT_128.bitsNumber;
        byte[] cipherKey = new byte[keyLength / 8];
        for (int i = 0; i < cipherKey.length; i++) {
            cipherKey[i] = (byte) ThreadLocalRandom.current().nextInt();
        }

        byte[] iv = new byte[rc6.getOpenTextBlockSizeInBytes()];
        for (int i = 0; i < iv.length; i++) {
            iv[i] = (byte) ThreadLocalRandom.current().nextInt();
        }

        byte[] hash = new byte[rc6.getOpenTextBlockSizeInBytes()];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = (byte) ThreadLocalRandom.current().nextInt();
        }

        try (SymmetricBlockCypher cipher = SymmetricBlockCypher.build(cipherKey, SymmetricalBlockMode.CTR, rc6, null, 0)) {
            File one = new File("C:\\Users\\Timofey.LAPTOP-KQGJSA46\\Desktop\\des\\1.txt");
            File two = new File("C:\\Users\\Timofey.LAPTOP-KQGJSA46\\Desktop\\des\\2.txt");
            File three = new File("C:\\Users\\Timofey.LAPTOP-KQGJSA46\\Desktop\\des\\3.txt");

            two.delete();
            three.delete();

            CypherInformant encodedCypherInformant = new CypherInformant(one.length());
            cipher.encode(one, two, encodedCypherInformant);

            CypherInformant decodedCypherInformant = new CypherInformant(two.length());
            cipher.decode(two, three, decodedCypherInformant);

            System.out.println(Files.mismatch(Path.of(one.getPath()), Path.of(three.getPath())));
            assert (Files.mismatch(Path.of(one.getPath()), Path.of(three.getPath())) == -1);

            System.out.println("Bytes encoded:" + encodedCypherInformant.getPercentsOfProcessedBytes() + " " + one.length());
            System.out.println("Bytes decoded:" + decodedCypherInformant.getPercentsOfProcessedBytes() + " " + two.length());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkImage() {
        RC6Bits32 rc6 = RC6Bits32.getInstance(
                new RoundKeysGeneratorImpl(32, 20, RC6Bits32.CipherKeyLength.BIT_192)
        );

        int keyLength = RC6Bits32.CipherKeyLength.BIT_192.bitsNumber;
        byte[] cipherKey = new byte[keyLength / 8];
        for (int i = 0; i < cipherKey.length; i++) {
            cipherKey[i] = (byte) ThreadLocalRandom.current().nextInt();
        }

        byte[] iv = new byte[rc6.getOpenTextBlockSizeInBytes()];
        for (int i = 0; i < iv.length; i++) {
            iv[i] = (byte) ThreadLocalRandom.current().nextInt();
        }

        byte[] hash = new byte[rc6.getOpenTextBlockSizeInBytes()];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = (byte) ThreadLocalRandom.current().nextInt();
        }

        try (SymmetricBlockCypher cipher = SymmetricBlockCypher.build(cipherKey, SymmetricalBlockMode.CTR, rc6,null, 2)) {
            File one = new File("C:\\Users\\Timofey.LAPTOP-KQGJSA46\\Desktop\\des\\1.jpg");
            File two = new File("C:\\Users\\Timofey.LAPTOP-KQGJSA46\\Desktop\\des\\2.jpg");
            File three = new File("C:\\Users\\Timofey.LAPTOP-KQGJSA46\\Desktop\\des\\3.jpg");

            two.delete();
            three.delete();

            CypherInformant encodedCypherInformant = new CypherInformant(one.length());
            cipher.encode(one, two, encodedCypherInformant);

            CypherInformant decodedCypherInformant = new CypherInformant(two.length());
            cipher.decode(two, three, decodedCypherInformant);

            System.out.println(Files.mismatch(Path.of(one.getPath()), Path.of(three.getPath())));
            assert (Files.mismatch(Path.of(one.getPath()), Path.of(three.getPath())) == -1);

            System.out.println("Bytes encoded:" + encodedCypherInformant.getPercentsOfProcessedBytes() + " " + one.length());
            System.out.println("Bytes decoded:" + decodedCypherInformant.getPercentsOfProcessedBytes() + " " + two.length());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkVideo() {
        RC6Bits32 rc6 = RC6Bits32.getInstance(
                new RoundKeysGeneratorImpl(32, 20, RC6Bits32.CipherKeyLength.BIT_256)
        );

        int keyLength = RC6Bits32.CipherKeyLength.BIT_256.bitsNumber;
        byte[] cipherKey = new byte[keyLength / 8];
        for (int i = 0; i < cipherKey.length; i++) {
            cipherKey[i] = (byte) ThreadLocalRandom.current().nextInt();
        }

        byte[] iv = new byte[rc6.getOpenTextBlockSizeInBytes()];
        for (int i = 0; i < iv.length; i++) {
            iv[i] = (byte) ThreadLocalRandom.current().nextInt();
        }

        byte[] hash = new byte[rc6.getOpenTextBlockSizeInBytes()];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = (byte) ThreadLocalRandom.current().nextInt();
        }

        try (SymmetricBlockCypher cipher = SymmetricBlockCypher.build(cipherKey, SymmetricalBlockMode.CTR, rc6, null, 4)) {
            File one = new File("C:\\Users\\Timofey.LAPTOP-KQGJSA46\\Desktop\\des\\1.mp4");
            File two = new File("C:\\Users\\Timofey.LAPTOP-KQGJSA46\\Desktop\\des\\2.mp4");
            File three = new File("C:\\Users\\Timofey.LAPTOP-KQGJSA46\\Desktop\\des\\3.mp4");

            two.delete();
            three.delete();

            CypherInformant encodedCypherInformant = new CypherInformant(one.length());
            cipher.encode(one, two, encodedCypherInformant);

            CypherInformant decodedCypherInformant = new CypherInformant(two.length());
            cipher.decode(two, three, decodedCypherInformant);

            System.out.println(Files.mismatch(Path.of(one.getPath()), Path.of(three.getPath())));
            assert (Files.mismatch(Path.of(one.getPath()), Path.of(three.getPath())) == -1);

            System.out.println("Bytes encoded:" + encodedCypherInformant.getPercentsOfProcessedBytes() + " " + one.length());
            System.out.println("Bytes decoded:" + decodedCypherInformant.getPercentsOfProcessedBytes() + " " + two.length());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}