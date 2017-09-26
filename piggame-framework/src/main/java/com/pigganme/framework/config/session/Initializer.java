package com.pigganme.framework.config.session;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class Initializer extends AbstractHttpSessionApplicationInitializer{

	public Initializer() {
		super(SessionConfig.class);
	}
}
