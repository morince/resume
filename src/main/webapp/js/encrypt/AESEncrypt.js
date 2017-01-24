/**
 * aes加密工具类
 * 
 */
//十六位十六进制数作为秘钥
var key = CryptoJS.enc.Utf8.parse("MYRESUMEEMUSERYM");
//十六位十六进制数作为秘钥偏移量
var iv = CryptoJS.enc.Utf8.parse("2000000010000000");
function encrypt(word) {
	srcs = CryptoJS.enc.Utf8.parse(word);
	var encrypted = CryptoJS.AES.encrypt(srcs, key, {
		iv : iv,
		mode : CryptoJS.mode.CBC,
		padding : CryptoJS.pad.Pkcs7
	});
	return encrypted.toString();
}

function decrypt(word) {
	var encryptedHexStr = CryptoJS.enc.Hex.parse(word);
	var srcs = CryptoJS.enc.Base64.stringify(encryptedHexStr);
	var decrypt = CryptoJS.AES.decrypt(srcs, key, {
		iv : iv,
		mode : CryptoJS.mode.CBC,
		padding : CryptoJS.pad.Pkcs7
	});
	var decryptedStr = decrypt.toString(CryptoJS.enc.Utf8);
	return decryptedStr.toString();
}

//var mm = encrypt('nihao')
//console.log(mm);
//var jm = Decrypt(mm);
//console.log(jm);