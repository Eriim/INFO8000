package Survey;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessObjects.Answers;
import BusinessObjects.Category;
import BusinessObjects.QuestionAnswer;
import BusinessObjects.Questionnaire;
import BusinessObjects.Questions;
import Database.DAO;

/**
 * Servlet implementation class ResultsServlet
 */
@WebServlet("/ResultsServlet")
public class ResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			Connection conn = DAO.OpenConnection("eric", "123");
			
			ArrayList<Category> categoryList = DAO.getSurveyCategory(conn);		
			
			ArrayList<Questions> questionList = DAO.getSureyQuestions(conn);
			
			ArrayList<Answers> answerList = new ArrayList<Answers>();
			
			Questionnaire questionnaire = new Questionnaire();
			
			
			
			ArrayList<QuestionAnswer> qa = new ArrayList<QuestionAnswer>();
			
			
			System.out.println(questionList.size());
			
			for (int i = 0; i < questionList.size(); i++) {
				System.out.println(i);
				String index = Integer.toString(i + 1);
				Answers tempAnswer = new Answers();
				tempAnswer.setAnswerText(request.getParameter(index));
				
				QuestionAnswer tempQuestionAnswer = new QuestionAnswer();
				tempQuestionAnswer.setQuestion(questionList.get(i));
				tempQuestionAnswer.setAnswer(tempAnswer);
				qa.add(tempQuestionAnswer);		
				
			}
			
			
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("questionList", questionList);	
			request.setAttribute("questionAnswerList", qa);
			
			for (QuestionAnswer quest : qa) {
				
				System.out.println(quest.getAnswer().getAnswerText());
				
			}
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher("/answers.jsp").forward(request, response);
	}

}
