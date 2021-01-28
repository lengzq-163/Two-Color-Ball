package com.lzq.demo.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class StellarApolloConfig {
    
	@Value("${spring.datasource.url}")
	private String springDatasourceUrl = "localhost";
	
	@ApolloConfigChangeListener
	private void listenRestartChange(ConfigChangeEvent changeEvent) {
		if (changeEvent.isChanged("spring.datasource.url")) {
			log.info("spring.datasource.url变化");
			springDatasourceUrl = changeEvent.getChange("spring.datasource.url").getNewValue().trim();
			log.info("spring.datasource.url变化,springDatasourceUrl={}", springDatasourceUrl);
		}
	}
	
}