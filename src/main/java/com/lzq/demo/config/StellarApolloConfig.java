package com.lzq.demo.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Data
@Component
public class StellarApolloConfig {

	private String changeConfigValue = "";
	
	@ApolloConfigChangeListener
	private void listenRestartChange(ConfigChangeEvent changeEvent) {
		Set<String> keys = changeEvent.changedKeys();
		for(String key:keys) {
			if (changeEvent.isChanged(key)) {
				log.info(String.format("%s变化",key));
				changeConfigValue = changeEvent.getChange(key).getNewValue().trim();
				log.info(String.format("%s变化,changeConfigValue={}",key), changeConfigValue);
			}
		}
	}
	
}