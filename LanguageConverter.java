package com.producer.consumer;

public class LanguageConverter implements LanguageTranslator {
	@Override
	public String fromDefaultLanguage(String languageTokens) {
		
		char c[] = languageTokens.toCharArray();
		
		for(int i=0;i<c.length;i++) {
			
			c[i] =  (char)(c[i]+3);
		}
		
		return String.valueOf(c);
	}
	
	// Translates the language to default language
	@Override
	public String toDefaultLanguage(String languageTokens) {
		
		char c[] = languageTokens.toCharArray();
		
		for(int i=0;i<c.length;i++) {
			
			c[i] =  (char)(c[i]-3);
		}
		
		return String.valueOf(c);
	}
	
	public static void main(String[] args) {
		
		System.out.println(new LanguageConverter().fromDefaultLanguage("Java"));
		System.out.println(new LanguageConverter().toDefaultLanguage("Mdyd"));

	}

}
