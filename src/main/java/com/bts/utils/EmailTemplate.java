package com.bts.utils;


public class EmailTemplate {
	
	public static String getVerificationEmailTemplate(String name, String verificationLink ) {
		
		String htmlContent = """
			    <!DOCTYPE html>
			    <html>
			    <head>
			        <meta charset="UTF-8">
			        <meta name="viewport" content="width=device-width, initial-scale=1.0">
			        <title>Welcome to Nimbus</title>
			        <style>
			            body { 
			                margin: 0; padding: 0; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
			                background-color: #f3f4f6; 
			            }
			            .email-container { 
			                max-width: 600px; margin: 40px auto; background-color: #ffffff; 
			                border-radius: 10px; overflow: hidden; box-shadow: 0 4px 15px rgba(0,0,0,0.05); 
			            }
			            .header-banner { 
			                background-color: #4f46e5; padding: 30px 20px; text-align: center; color: #ffffff; 
			            }
			            .header-banner h1 { 
			                margin: 0; font-size: 24px; letter-spacing: 1.5px; text-transform: uppercase; 
			            }
			            .main-content { 
			                padding: 40px 30px; color: #374151; line-height: 1.6; font-size: 16px; 
			            }
			            .main-content h2 { 
			                margin-top: 0; color: #111827; font-size: 20px; 
			            }
			            .action-btn { 
			                display: inline-block; padding: 14px 28px; background-color: #4f46e5; 
			                color: #ffffff !important; text-decoration: none; border-radius: 6px; 
			                font-weight: 600; font-size: 16px; margin: 20px 0; 
			            }
			            .footer-section { 
			                background-color: #f9fafb; padding: 20px; text-align: center; 
			                font-size: 13px; color: #6b7280; border-top: 1px solid #e5e7eb; 
			            }
			        </style>
			    </head>
			    <body>
			        <div class="email-container">
			            
			            <div class="header-banner">
			                <h1>Welcome to Nimbus</h1>
			            </div>
			            
			            <div class="main-content">
			                <h2>Hello {username},</h2>
			                <p>Welcome to the Nimbus, India's most advanced bus service platform. We are thrilled to have you on board.</p>
			                <p>Please verify your email address by clicking on the link below.</p>
			                
			                <div style="text-align: center;">
			                    <a href="{verificationLink}" class="action-btn">Verify My Account</a>
			                </div>
			                
			                <p style="margin-top: 20px; font-size: 14px; color: #6b7280;">
			                    If you didn't request this email, you can safely ignore it. Your account will not be activated until you verify.
			                </p>
			                <p style="margin-bottom: 0; margin-top: 30px;">
			                    From team nimbus.
			                </p>
			            </div>
			            
			            <div class="footer-section">
			                <p style="margin: 0;">&copy; 2026 Nimbus. All rights reserved.</p>
			            </div>
			            
			        </div>
			    </body>
			    </html>
			    """
				.replace("{username}", name)
			    .replace("{verificationLink}", verificationLink);
			    ;
			    
			    return htmlContent;
	}
}
