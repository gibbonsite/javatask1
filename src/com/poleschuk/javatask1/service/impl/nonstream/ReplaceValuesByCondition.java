package com.poleschuk.javatask1.service.impl.nonstream;

import com.poleschuk.javatask1.entity.CustomArray;
import com.poleschuk.javatask1.service.CustomArrayCondition;
import com.poleschuk.javatask1.service.CustomArrayReplacer;

public class ReplaceValuesByCondition {

	private CustomArray array;
	
	private CustomArrayCondition condition;
	
	private CustomArrayReplacer replacer;
	
	public ReplaceValuesByCondition(CustomArray array,
			CustomArrayReplacer simpleReplacer, CustomArrayCondition simpleCondition)  {
		this.array = array;
		this.replacer = simpleReplacer;
		this.condition = simpleCondition;
	}
	
	public void perform() {		
		for (int i = 0; i < array.length(); i++) {
			if (condition.evaluate(i)) {
				replacer.replace(i);
			}
		}
	}
}
