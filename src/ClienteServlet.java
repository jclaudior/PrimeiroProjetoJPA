

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import br.com.rdevs.util.HttpUtil;

import br.com.rdevs.entity.ClienteEntity;
import br.com.rdevs.service.ClienteService;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		ClienteService clienteService = new ClienteService();
		ClienteEntity cliente = clienteService.burcarPorId(Integer.valueOf(codigo));
		
		Gson json = new Gson();
		String jsonCliente = json.toJson(cliente);
		
		response.getWriter().append(jsonCliente);
		response.setContentType("application/json");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonCliente = HttpUtil.getBody(request);
		Gson json = new Gson();
		ClienteEntity cliente = json.fromJson(jsonCliente,ClienteEntity.class);
		ClienteService clienteService = new ClienteService();
		clienteService.inserir(cliente);
		response.getWriter().append("Registro inserido com sucesso");
		response.setStatus(201);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonCliente = HttpUtil.getBody(request);
		Gson json = new Gson();
		ClienteEntity cliente = json.fromJson(jsonCliente,ClienteEntity.class);
		ClienteService clienteService = new ClienteService();
		clienteService.atualizar(cliente);
		response.getWriter().append("Registro atualizado com sucesso");
		response.setStatus(201);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		ClienteService clienteService = new ClienteService();
		clienteService.deletar(Integer.valueOf(codigo));
		response.getWriter().append("Registro deletado com sucesso");
		response.setStatus(201);
	}

}
