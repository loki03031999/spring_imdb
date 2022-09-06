package com.spring.imdb.business.bean;

import java.util.Set;

public class MovieAndEpisodeAndActorsBean extends MovieAndEpisodeBean{
	
	public Set<PersonBean> personBean;

	public Set<PersonBean> getPersonBean() {
		return personBean;
	}

	public void setPersonBean(Set<PersonBean> personBean) {
		this.personBean = personBean;
	}
	
}
