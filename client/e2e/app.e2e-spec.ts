import { CinemaPage } from './app.po';

describe('cinema App', function() {
  let page: CinemaPage;

  beforeEach(() => {
    page = new CinemaPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
