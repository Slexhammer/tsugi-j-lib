/**
 * Copyright 2014 Unicon (R)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ltistarter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * This controller should be protected by basic auth authentication (on the /admin path)
 * Username and password controlled in application.properties
 */
@Controller
@RequestMapping("/basic")
public class BasicController extends HomeController {

    @RequestMapping({"", "/"})
    public String home(HttpServletRequest req, Principal principal, Model model) {
        commonModelPopulate(req, principal, model);
        model.addAttribute("name", "basic");
        return "home"; // name of the template
    }

    @RequestMapping("/logout")
    public String logout() {
        // should be handled by spring security
        return "redirect:/"; // go home
    }

}