package xyz.jangle.handlers.handlers;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Shell;

/**
 * <b>Warning</b> : As explained in <a href=
 * "http://wiki.eclipse.org/Eclipse4/RCP/FAQ#Why_aren.27t_my_handler_fields_being_re-injected.3F">this
 * wiki page</a>, it is not recommended to define @Inject fields in a handler.
 * <br/>
 * <br/>
 * <b>Inject the values in the @Execute methods</b>
 */
public class SystemExplorerMenuHandlers {

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell s) {

//		MessageDialog.openInformation(s, "E4 Information Dialog", s.getLocation().toString());
		try {
			String exe = "C:\\Windows\\explorer.exe "; // 执行器
			String path = "D:\\workspace2018June"; // 执行参数   这个参数要改为，通过插件获取选中文件夹的系统路径
			String cmd = exe + path;
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
