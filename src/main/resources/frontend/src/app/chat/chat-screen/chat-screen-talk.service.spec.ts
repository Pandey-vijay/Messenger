import { TestBed } from '@angular/core/testing';

import { ChatScreenTalkService } from './chat-screen-talk.service';

describe('ChatScreenTalkService', () => {
  let service: ChatScreenTalkService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChatScreenTalkService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
