package com.example.modernmum;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import android.os.Bundle;



public class ChatScreenActivity<ChatMessage> extends Activity {
	private List chatMessageList = new ArrayList();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		
	}
	

		public void add(ChatMessage object) {
			chatMessageList.add(object);
			
		}

	
		public int getCount() {
			return this.chatMessageList.size();
		}

		public ChatMessage getItem(int index) {
			return (ChatMessage) this.chatMessageList.get(index);
		}

		
	}

	

