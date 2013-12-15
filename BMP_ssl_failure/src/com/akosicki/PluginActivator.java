package com.akosicki;

import java.net.InetAddress;

import net.lightbody.bmp.proxy.ProxyServer;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class PluginActivator extends AbstractUIPlugin {

	private ProxyServer proxy;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);

		System.out.println("starting the bmp proxy (on 9095)");
		proxy = new ProxyServer(9095);
		proxy.setLocalHost(InetAddress.getByName("127.0.0.1"));
		proxy.start();
	}

	public void stop(BundleContext context) throws Exception {
		super.stop(context);

		System.out.println("shutting down the bmp proxy");
		proxy.stop();
		proxy.cleanup();
	}

}
