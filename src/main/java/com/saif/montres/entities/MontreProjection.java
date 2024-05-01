package com.saif.montres.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMon", types = { Montre.class })
public interface MontreProjection {
	public String getNomMontre();
}
