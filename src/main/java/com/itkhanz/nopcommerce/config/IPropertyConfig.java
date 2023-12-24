package com.nopcommerce.config;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config.properties")
public interface IPropertyConfig extends Config, IFrameworkConfig {
  String baseURL();

  String useremail();

  @DefaultValue("admin")
  String password();
}
