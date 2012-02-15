import os
from google.appengine.ext.webapp import template
from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app

class MainPage(webapp.RequestHandler):
  def get(self):
    user_agent = str(self.request.headers['User-Agent'])
    source = "web"
    if "makercalc_android_app" in user_agent:
      source = "Android"
    greetings = 'Hello, %s makers!' % (source,)
    template_values = {
      'greetings': greetings,
      'url': "url woo!",
      'url_linktext': "url link text",
    }
    path = os.path.join(os.path.dirname(__file__), 'templates/index.html')
    self.response.out.write(template.render(path, template_values))

class MathPage(webapp.RequestHandler):
  def get(self):
    user_agent = str(self.request.headers['User-Agent'])
    source = "web"
    if "makercalc_android_app" in user_agent:
      source = "Android"
    greetings = 'Hello, %s makers!' % (source,)
    template_values = {
      'greetings': greetings,
      'url': "url woo!",
      'url_linktext': "url link text",
    }
    path = os.path.join(os.path.dirname(__file__), 'templates/math.html')
    self.response.out.write(template.render(path, template_values))

application = webapp.WSGIApplication(
                                     [('/', MainPage),
                                      ('/math', MathPage)],
                                     debug=True)

def main():
  run_wsgi_app(application)

if __name__ == "__main__":
  main()
