/**
 * 
 */
function validate()
{
	var firstname 	=	document.forms["register"]["fname"].value;
	var lastname 	=	document.forms["register"]["lname"].value;
	var contactno	=	document.forms["register"]["MNum"].value;
    var email		=	document.forms["register"]["email"].value;
    var password	=	document.forms["register"]["pass"].value;
    var password1	=	document.forms["register"]["pass2"].value;
   
	
        if(isAlphebaticf(firstname))
        {
            if(isAlphebaticl(lastname))
                {
                    if(isAlphanumeric(contactno))
                    {
                            if(emailValidation(email))
                            {
                                                 
                            	if(password===password1)
                                {
                                      if(passValidation(password,8))
                                      {
                                    	  return true;
                                       }
                                       else
                                       {
                                         return false;
                                        }
                                }
                                else
                                {
                                	alert("Password didn't match");
                                	return false;
                                }
                            }   
                               else{
                                   return false;
                               }
                        }
                        else
                        {
                          return false;
                        }
                  }
                  else{
                      return false;
                  }
              }
              else{
                  return false;
              }
  }

function isAlphebaticf(elemValue)
{
    var exp = /^[a-zA-Z_ ]*$/;
    if(!isEmpty(elemValue))
    {
        if(elemValue.match(exp))
        {
            return true;
        }
        else
        {
            alert("Enter text only for your first name");
            return false;
        }
    }
}


function isAlphebaticl(elemValue)
{
    var exp = /^[a-zA-Z_ ]*$/;
    if(!isEmpty(elemValue))
    {
        if(elemValue.match(exp))
        {
            return true;
        }
        else
        {
            alert("Enter text only for your last name");
            return false;
        }
    }
}



function isAlphanumeric(elemValue)
{
	var exp2 = /^[0-9]+$/;
	if(!isEmpty(elemValue))
	{
		if(elemValue.match(exp2))
		{
			return true;
		}
		else
		{
			alert("Enter only the numbers for Contact number");
			return false;
		}
	}
}

function isEmpty(elemValue)
{
    if(elemValue==""  || elemValue==null)
    {
        alert("You cannot keep fields empty");
        return true;
    }
    else
    {
        return false;
    }
}		

function emailValidation(elemValue)
{
    if(!isEmpty(elemValue))
    {
        var atops = elemValue.indexOf("@");
        var dotops = elemValue.indexOf(".");
        
        if(atops <1 || dotops+2 >=elemValue.length || atops+2>dotops)
        {
            alert("Enter a valid Email Address");
            return false;
        }
        else
        {
            return true;
        }
    }
    else
    {
        return false;
    }
} 


function passValidation(elemValue,min)
{
    var exp3=/^(?=.*[a-zA-Z0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]+$/;

    if(!isEmpty(elemValue))
    {
        if(elemValue.length>=min)
        {
            if(elemValue.match(exp3))
            {
                return true;
            }
            else
            {
                alert("Password should consist at least a upper case, lower case letter,special Character and number");
                return false;
            }
        }
        else
        {
            alert("Password should at least 8 characters long");
            return false;
        }
    }
    else
    {
        return false;
    }
}
