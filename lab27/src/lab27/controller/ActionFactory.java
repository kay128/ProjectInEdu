package lab27.controller;

import lab27.action.*;

public class ActionFactory {
	
	private ActionFactory(){
		super();
	}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command){
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		switch(command) {
		
		case "m_regist_form":
			action = new MRegistFormAction();
			break;
		case "m_regist":
			action = new MRegistAction();
			break;		
			
		case "m_login_form":
			action = new MLoginFormAction();
			break;
		case "m_login":
			action = new MLoginAction();
			break;	
			
		case "m_modify_form":
			action = new MModifyFormAction();
			break;
		case "m_modify":
			action = new MModifyAction();
			break;
			
		case "m_logout":
			action = new MLogoutAction();
			break;
			
		case "m_delete":
			action = new MDeleteAction();
			break;
			
		case "m_study":
			action = new MStudyAction();
			break;
			
		case "p_write_form":
			action = new PWritePostFormAction();
			break;
		case "p_write":
			action = new PWritePostAction();
			break;
			
		case "p_select_post":
			action = new PSelectPostAction();
			break;
			
		case "p_select_one_post":
			action = new PSelectOnePostAction();
			break;
			
		case "p_update_form":
			action = new PUpdatePostFormAction();
			break;
		case "p_update":
			action = new PUpdatePostAction();
			break;
			
		case "p_delete":
			action = new PDeletePostAction();
			break;
			
		case "r_write":
			action = new RWriteReplyAction();
			break;
			
		case "r_update":
			action = new RUpdateReplyAction();
			break;
			
		case "r_delete":
			action = new RDeleteReplyAction();
			break;
			
		case "r_rate":
			action = new RReplyRateAction();
			break;
			
		case "a_login":
			action = new ALoginAction();
			break;
		
		case "a_user_search":
			System.out.println("a user search 시작");
			action = new AUSearchAction();
			System.out.println("a user search 끝");
			break;
		
		case "a_community_search":
			action = new ACSearchAction();
			break;
			
		case "communityDrop" :
	         action = new CCommunityDropAction();
	         break;	
			
		case "search":
			action = new SearchAction();
			break;
			
		case "com_list":
			action = new ComListAction();
			break;
			
		case "delete_pavorite":
			action = new DeletePavoriteAction();
			break;
			
		case "add_pavorite":
			action = new AddPavoriteAction();
			break;
			
		case "oneCompany":
			action = new OneCompanyAction();
			break;
			
		case "addRating":
			action = new AddRatingAction();
			break;
			
		case "viewOnePost" :
			action = new PSelectOnePostAction();
			break;
			
		case "communityMain" :
			action = new CCommunityMainAction();
			break;
			
		case "communityPage" :
			action = new CSelectOneCommunity();
			break;
		
		case "communityJoin" :
		    action = new CCommunityJoinAction();
		    break;
			
		case "searchpage" :
			action = new CCommunitySearchAction();
			break;
			
		case "updateFav" : 
			action = new CFavoriteAction();
			break;
		
		case "market_list":
			action = new PMarketListAction();
			break;
			
		case "itStudyForm" :
	         action = new SItStudyFormAction();
	         break;
	         
	      case "jpStudyForm" :
	         action = new SJpStudyFormAction();
	         break;
		}
		
		return action;
	}

}
