package com.kakaobank.restclient;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kakaobank.stamp.e2e.E2eEncryptor;


public class TestE2eEncrypt {
	
	@Test
	public void test() throws Exception{
		String msg = "12345";
        String e2eId = "ABC"; // 원래 stamp server로부터 주어짐..

        // CS : 고객센터 key 생성 및 public key추출
        E2eEncryptor e2e = new E2eEncryptor();
        String csPublicKey = e2e.getCsPublicKey();

        // STAMP : stamp server 에서의 key 생성 및…
        E2eEncryptor stamp = new E2eEncryptor();
        String stampPublicKey = stamp.getCsPublicKey();
        stamp.setStampPublicKey(csPublicKey);

        // CS :  서버로부터의 publicKey 및 e2eId 넣기
        e2e.setStampPublicKey(stampPublicKey);
        e2e.setE2eId(e2eId);

        // CS : encrypt
        String encrypted = e2e.encryptMessage(msg);

        // STAMP :  decrypt
        String decrypted = stamp.decryptMessage(encrypted);
        
        System.out.println("ORGINAL : "  + msg);
        System.out.println("DECRYPT : " + decrypted);
        assertEquals(msg, decrypted);
	}

}
